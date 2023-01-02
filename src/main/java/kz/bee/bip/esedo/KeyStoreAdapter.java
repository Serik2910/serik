package kz.bee.bip.esedo;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;

public interface KeyStoreAdapter {

    public static final String KEYSTORE_TYPE__JKS = "JKS";
    public static final String KEYSTORE_TYPE__PKCS12 = "PKCS12";

    public abstract KeyStore getKeyStore() throws IOException, NoSuchProviderException, NoSuchAlgorithmException, KeyStoreException, CertificateException;
}
