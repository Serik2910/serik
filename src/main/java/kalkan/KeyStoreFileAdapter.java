package kalkan;


import kz.gov.pki.kalkan.jce.provider.KalkanProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import soap.start.serik.models.Const;


import java.io.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;


@Component
public class KeyStoreFileAdapter implements KeyStoreAdapter{
    private static final Logger LOGGER = LogManager.getLogger(KeyStoreFileAdapter.class);

    private String storetype; //JKS | PKCS12

    private String storefileUrl;

    private String storepass;

    private String alias;

    public String getStoretype() {
        return storetype;
    }

    public String getStorefileUrl() {
        return storefileUrl;
    }

    public String getStorepass() {
        return storepass;
    }

    public String getAlias() {
        return alias;
    }

    private KeyStoreFileAdapter() {
        storefileUrl = Const.getValue(Const.STORE_FILE_LOCATION);
        storepass = Const.getValue(Const.STORE_FILE_PASS);
        alias = Const.getValue(Const.STORE_ALIAS);
        storetype = Const.getValue(Const.STORE_TYPE);
        // VFigurov: не убирать! Конструктор специально сделан private
        LOGGER.debug("Start initiating a new Instance...");
    }

    public static KeyStoreFileAdapter getStoreFileAdapter() {
        KeyStoreFileAdapter adapter = new KeyStoreFileAdapter();

        LOGGER.debug("new Instance created. [storetype="+adapter.storetype+", storefileUrl="+adapter.storefileUrl+"]");
        return adapter;
    }

    @Override
    public KeyStore getKeyStore() throws IOException, NoSuchProviderException, NoSuchAlgorithmException, KeyStoreException, CertificateException {
        return getKeyStore(storetype, storefileUrl, storepass);
    }

    /**
     *
     * @param storetype - "PKCS12", "JKS"
     * @param filename   -
     * @param password   -
     * @return KeyStore obj or Exception
     *
     * @throws IOException
     * @throws KeyStoreException
     * @throws NoSuchProviderException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     */
    public KeyStore getKeyStore(String storetype, String filename, String password) throws
            IOException,
            KeyStoreException,
            NoSuchProviderException,
            NoSuchAlgorithmException,
            CertificateException {
        LOGGER.debug("Try load keystore from FILE_SYSTEM: " + filename);
        char[] passBytes = password.toCharArray();
        byte[] p12Bytes = readFile(filename);
        LOGGER.debug("Store type is: " + storetype);
        KeyStore ks;
        if (storetype.equals(KEYSTORE_TYPE__PKCS12)) {
            ks = KeyStore.getInstance(storetype, KalkanProvider.PROVIDER_NAME);

        } else {
            ks = KeyStore.getInstance(storetype);
        }
        ks.load(new ByteArrayInputStream(p12Bytes), passBytes);
        LOGGER.debug("keyStore from FILE_SYSTEM succ got: " + ks);
        return ks;
    }

    /**
     *Считать файл
     *
     * @param filename  -
     * @return          -
     * @throws IOException -
     */
    private byte[] readFile(String filename) throws IOException {
        LOGGER.debug("Invoke for: " + filename);
        Resource resource;
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        resource=resourceLoader.getResource(filename);
        InputStream stream = resource.getInputStream();
        byte[] byteArray = new byte[stream.available()];
        stream.read(byteArray);
        return byteArray;
    }
}
