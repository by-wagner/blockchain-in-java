package kryowizardry;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileOutputStream;
import java.io.IOException;

class Solution {
    public void doSerialization(Wizard wizard, String filename) throws IOException {
        Kryo kryo = new Kryo();
        kryo.register(Wizard.class);

        try (Output output = new Output(new FileOutputStream(filename))) {
            kryo.writeObject(output, wizard);
        } catch (IOException e) {
            throw new IOException("Error during serialization", e);
        }
    }
}