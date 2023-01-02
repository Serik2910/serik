package kz.bee.bip.esedo;

import kz.gov.pki.kalkan.jce.provider.KalkanProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;


public class KeyStoreFileAdapter implements KeyStoreAdapter{
    private static final Logger LOGGER =  LogManager.getLogger(KeyStoreFileAdapter.class);

    private String storetype; //JKS | PKCS12
    private String storefileUrl;
    private String storepass;

    private KeyStoreFileAdapter() {
        // VFigurov: не убирать! Конструктор специально сделан private
        LOGGER.debug("Start initiating a new Instance...");
    }

    public KeyStoreFileAdapter(String storetype, String storefileUrl, String storepass) {
        this();
        this.storetype = storetype;
        this.storefileUrl = storefileUrl;
        this.storepass = storepass;
        LOGGER.debug("new Instance created. [storetype="+storetype+", storefileUrl="+storefileUrl+"]");
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
        File file = new File(filename);
        byte[] byteArray = new byte[(int)file.length()];
        DataInputStream dataIs = new DataInputStream(new FileInputStream(file));
        dataIs.readFully(byteArray);
        dataIs.close();
        return byteArray;
    }
}
