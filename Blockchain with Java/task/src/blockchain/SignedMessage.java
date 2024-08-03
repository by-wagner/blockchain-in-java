package blockchain;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class SignedMessage {
    private String message;
    private byte[] signature;

    public SignedMessage(String message, PrivateKey privateKey) throws Exception {
        this.message = message;
        this.signature = signMessage(message, privateKey);
    }

    private byte[] signMessage(String message, PrivateKey privateKey) throws Exception {
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        sign.update(message.getBytes());
        return sign.sign();
    }

    public boolean verifyMessage(PublicKey publicKey) throws Exception {
        Signature verify = Signature.getInstance("SHA256withRSA");
        verify.initVerify(publicKey);
        verify.update(message.getBytes());
        return verify.verify(signature);
    }

    public String getMessage() {
        return message;
    }

    public byte[] getSignature() {
        return signature;
    }
}