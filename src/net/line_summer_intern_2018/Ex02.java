package net.line_summer_intern_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// LINE 인턴 코딩 테스트 2번 문제 캔버스
public class Ex02 {
    public static void main(String[] args) throws IOException {
        Pattern onlyNum = Pattern.compile("[0-9]+");
        Pattern onlyHex = Pattern.compile("0x[0-9a-f]+");
        Pattern onlyAlp = Pattern.compile("[a-z]+");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sizeInfo = br.readLine();
        Matcher numberMatch = onlyNum.matcher(sizeInfo);
        while(numberMatch.find()){
            bw.write(String.format("%s\n", numberMatch.group(0)));
        }

        String colorInfo = br.readLine();
        Matcher colorMatch = onlyHex.matcher(colorInfo);
        while(colorMatch.find()){
            bw.write(String.format("%s\n", Integer.decode(colorMatch.group(0))));
        }

        String frameInfo = br.readLine();
        numberMatch = onlyNum.matcher(frameInfo);

        String tmp = "0";
        while(numberMatch.find()){
            tmp = numberMatch.group(0);
            bw.write(String.format("%s\n", tmp));
        }
        int N = Integer.parseInt(tmp);

        String noInfo = br.readLine();
        noInfo = noInfo.replace("No.:", "");
        Matcher alpMatch = onlyAlp.matcher(noInfo);
        Map<Integer, String> infoMap = new HashMap<>();
        int idx = 0;
        while(alpMatch.find()){
            tmp = alpMatch.group(0);
            infoMap.put(idx++, tmp);
        }

        int width=0, height=0, duration=0, alpha=0;
        for(int k=0;k<N;k++){
            String canvasInfo = br.readLine();
            canvasInfo = canvasInfo.replace(String.format("%d:", k+1), "");
            canvasInfo = canvasInfo.replace("yes", "1");
            canvasInfo = canvasInfo.replace("no", "0");

            numberMatch = onlyNum.matcher(canvasInfo);
            idx = 0;
            while(numberMatch.find()){
                tmp = numberMatch.group(0);
                switch(infoMap.get(idx++)){
                    case "width" :
                        width = Integer.parseInt(tmp);
                        break;
                    case "height" :
                        height = Integer.parseInt(tmp);
                        break;
                    case "duration" :
                        duration = Integer.parseInt(tmp);
                        break;
                    case "alpha" :
                        alpha = Integer.parseInt(tmp);
                        break;
                }
            }

            if(k == N - 1) {
                bw.write(String.format("%dx%d, %d, %d", width, height, duration, alpha));
            } else {
                bw.write(String.format("%dx%d, %d, %d\n", width, height, duration, alpha));
            }
        }

        bw.flush();
    }
}

/*
 * Case 01.
 * Canvas Size : 600 x 400
 * Background Color : 0xfa023d
 * Number of frames: 5
 * No.: width height alpha duration
 * 1: 360 360 yes 150
 * 2: 360 360 yes 120
 * 3: 360 360 yes 110
 * 4: 360 360 no 140
 * 5: 360 360 yes 115
 *
 * 600
 * 400
 * 16384573
 * 5
 * 360x360, 150, 1
 * 360x360, 120, 1
 * 360x360, 110, 1
 * 360x360, 140, 0
 * 360x360, 115, 1
 *
 *
 * Case 02.
 * Canvas Size : 1280 x 720
 * Background Color : 0xab54da
 * Number of frames: 8
 * No.: width alpha duration height
 * 1: 1000 yes 150 1200
 * 2: 1000 yes 250 1000
 * 3: 2000 no 350 2000
 * 4: 1000 no 150 3000
 * 5: 3000 yes 250 4000
 * 6: 1000 yes 650 9000
 * 7: 5000 no 150 4500
 * 8: 6000 yes 250 8000
 *
 * 1280
 * 720
 * 11228378
 * 8
 * 1000x1200, 150, 1
 * 1000x1000, 250, 1
 * 2000x2000, 350, 0
 * 1000x3000, 150, 0
 * 3000x4000, 250, 1
 * 1000x9000, 650, 1
 * 5000x4500, 150, 0
 * 6000x8000, 250, 1
 */