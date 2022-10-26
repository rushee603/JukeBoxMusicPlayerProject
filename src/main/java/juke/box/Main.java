package juke.box;

import models.PlayAudio;

import java.util.Scanner;

public class Main {


    public void readAudio(String audioSrcFile, int count)  {
        PlayAudio playAudio = new PlayAudio();
        int c = 0;
        count = count - 1;
        try {

            playAudio.playAudio1(audioSrcFile, count);

            playAudio.play();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");

                if (c == 4) {break;}
                if (scanner.hasNextInt()) {
                    c = scanner.nextInt();}
                else {break;}
                switch (c) {
                    case 1:
                        playAudio.pause();
                        break;
                    case 2:
                        playAudio.resumeAudio();
                        break;
                    case 3:
                        playAudio.restart();
                        break;
                    case 4:
                        playAudio.stop();
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound." + ex);
        }
    }

}
