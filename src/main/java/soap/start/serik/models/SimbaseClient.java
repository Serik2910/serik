package soap.start.serik.models;


import kz.bee.bip.esedo.SyncSendMessageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.bouncycastle.jcajce.provider.digest.MD5;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;
import simbase.Sbapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.JAXB;
import java.io.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.TimeZone;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "simbase_clients")
public class SimbaseClient {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "simbase_user")
    private String simbase_user;

    @Column(name = "pass")
    private String pass;
    @Column(name = "pass_hash")
    private String pass_hash;

    @Column(name = "user_ip")
    private String user_ip;
    @Column(name = "message_id")
    private String message_id;

    @Column(name = "message_type")
    private String message_type;

    @Column(name = "url")
    private String URL;

    @Column(name = "function")
    private String function;

    @Column(name = "interface_id")
    private String interface_id;

    @Column(name = "interface_version")
    private String interface_version;
    public String sendDocToSimbase(SyncSendMessageRequest messageRequest) throws Exception {
        StringWriter sw = new StringWriter();
        JAXB.marshal(messageRequest,sw);
        String dataXml = sw.toString();
        java.lang.System.out.println(dataXml);
        Sbapi sbapi = new Sbapi();
        Sbapi.Header header = new Sbapi.Header();
        Sbapi.Header.Interface anInterface = new Sbapi.Header.Interface();
        anInterface.setId(String.valueOf(Long.parseLong(interface_id, 16)));
        anInterface.setVersion(interface_version);
        header.setInterface(anInterface);

        Sbapi.Header.Auth auth = new Sbapi.Header.Auth();
        SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
        String pwd;
        if(pass_hash!=null || pass_hash!=""){
            pwd = pass_hash;
        }else {
            byte[] digest = digestSHA3.digest(pass.getBytes());
            pwd = Hex.toHexString(digest);
        }
        String authValue = "<authdata msg_id=\"" + message_id + "\" user=\"" + simbase_user + "\" password=\"" + pwd + "\" msg_type=\"" + message_type + "\" user_ip=\""+user_ip+"\" />";
        auth.setPwd(pwd);
        auth.setValue(Base64.getEncoder().encodeToString(authValue.getBytes()));

        auth.setPwd("hash");
        header.setAuth(auth);

        Sbapi.Header.Message message = new Sbapi.Header.Message();
        message.setType(message_type);
        message.setId(message_id);
        message.setIgnoreId("yes");
        TimeZone tz = TimeZone.getTimeZone("GMT+6");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); // Quoted "Z" to indicate UTC, no timezone offset

        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());

        message.setCreated(nowAsISO);
        header.setMessage(message);

        Sbapi.Header.Error error = new Sbapi.Header.Error();
        error.setId("0");
        header.setError(error);
        sbapi.setHeader(header);
        Sbapi.Body body = new Sbapi.Body();
        Sbapi.Body.Function function = new Sbapi.Body.Function();
        function.setName(this.function);
        function.addArg("data", dataXml);
        body.setFunction(function);
        sbapi.setBody(body);

        StringWriter sw1 = new StringWriter();
        JAXB.marshal(sbapi,sw1);
        String xmlStringToLog = sw1.toString();
        //java.lang.System.out.println(xmlStringToLog);

        SSLContextBuilder builder = new SSLContextBuilder();
        builder.loadTrustMaterial(null, (x509Certificates, s) -> true);
        SSLConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(builder.build(),
                NoopHostnameVerifier.INSTANCE);
        HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslSF).build();
        HttpPost httppost = new HttpPost(URL);
        StringEntity stringEntity = new StringEntity(xmlStringToLog, "UTF-8");
        httppost.setEntity(stringEntity);
        HttpResponse response = httpClient.execute(httppost);
        HttpEntity entity = response.getEntity();
        String responseString = "";
        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                BufferedReader buf = new BufferedReader(new InputStreamReader(instream,"UTF-8"));
                if(response.getStatusLine().getStatusCode()!= HttpStatus.SC_OK)
                {
                    throw new Exception(response.getStatusLine().getReasonPhrase());
                }
                StringBuilder sb = new StringBuilder();
                String s;
                while(true )
                {
                    s = buf.readLine();
                    if(s==null || s.length()==0)
                        break;
                    sb.append(s);
                }
                buf.close();
                responseString  = sb.toString();
                //java.lang.System.out.println(responseString);
            }
        }
        return responseString;
    }
}
