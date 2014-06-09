package io.github.timeforthe;

import java.io.File;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FizzBuzz {

    public static ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(5);
    static File Fizz;
    static File Bang;
    static File directory = new File ("");

    public static void main(String[] args) {

        /**
         *      Replace: directory.getAbsolutePath() + "/FIZZ.WAV"
         *      and directory.getAbsolutePath() + "/BANG.WAV"
         *      with the location of your files, or the working
         *      directory.
         */

        Fizz = new File(directory.getAbsolutePath() + "/FIZZ.WAV");
        Bang = new File(directory.getAbsolutePath() + "/BANG.WAV");
        String a;

        for (int j = 1; j <= 50; j++) {

            if (j % 3 == 0 && j % 5 == 0) {
                a = "FizzBang: ";
                audio(1);
                audio(2);
            } else if (j % 3 == 0) {
                a = "Fizz: ";
                audio(1);
            } else if (j % 5 == 0) {
                a = "Buzz: ";
                audio(2);
            } else {
                a = "";
            }

            System.out.println(a + j);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.print(" :(");
            }

        }

        System.exit(0);
    }

    public static void audio(int a) {
        eventPool.schedule(new audioPlay(a), 0, TimeUnit.MILLISECONDS);
    }

    public static class audioPlay implements Runnable {
        File audioFile;

        audioPlay(int a) {
            if (a == 1) {
                this.audioFile = Fizz;
            } else {
                this.audioFile = Bang;
            }
        }

        @Override
        public void run() {
            try {
                AudioPlayer.player.start(new AudioStream( new FileInputStream(audioFile)));
            } catch (IOException e) {
                System.out.println("File not found : " + audioFile);
            }
        }
    }

}

