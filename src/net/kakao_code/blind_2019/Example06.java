package net.kakao_code.blind_2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example06 {
    static Map<String, Integer> dnsMap;
    static Web[] webs;

    static class Web {
        String dns;
        int word;
        double score;

        public Web(String dns, int word, double score){
            this.dns = dns;
            this.word = word;
            this.score = score;
        }

        public void addScore(double score){
            this.score += score;
        }

        @Override
        public String toString() {
            return String.format("[%s : %.1fpt]", this.dns, this.score);
        }
    }

    // 기본 점수 찾기는 정규식을 이용하려 했지만, 인덱스를 가져와서 하는 것이 더욱 빠르고 정확해 외부 링크를 참고해서 작성하였습니다.
    private static int basicPointCheck(String word, String html) {
        String compWord = word.toUpperCase();
        String compHtml = html.toUpperCase();

        int basicPoint = 0;
        int fromIndex = 0;

        int index = compHtml.indexOf(compWord, fromIndex);
        char[] arr = compHtml.toCharArray();

        while (index != -1) {
            if (!Character.isAlphabetic(arr[index - 1]) && !Character.isAlphabetic(arr[index + compWord.length()])) {
                basicPoint++;
            }

            index = compHtml.indexOf(compWord, index + compWord.length());
        }

        return basicPoint;
    }

    public static int solution(String word, String[] pages) {
        dnsMap = new HashMap<>();
        webs = new Web[pages.length];

        // 1단계. DNS 주소와 기본 점수 채점
        Pattern dnsMetaPattern = Pattern.compile("<meta[^>]*content=[\"']?([^>\"']+)[\"']?[^>]*>");
        String tmpDns = null;
        Matcher dnsMatcher;
        for(int k=0;k<pages.length;k++){
            dnsMatcher = dnsMetaPattern.matcher(pages[k]);

            if(dnsMatcher.find()) {
                tmpDns = dnsMatcher.group(1);
            }

            if(tmpDns != null) {
                int wordCnt = basicPointCheck(word, pages[k]);
                webs[k] = new Web(tmpDns, wordCnt, (double) wordCnt);
                dnsMap.put(tmpDns, k);
            }
        }

        // 2단계. 외부 링크를 이용한 채점
        Pattern hrefPattern = Pattern.compile("<a[^>]*href=[\"']?([^>\"']+)[\"']?[^>]*>");
        Matcher hrefMatcher;
        int links;
        List<Integer> visited;
        for(int k=0;k<pages.length;k++){
            hrefMatcher = hrefPattern.matcher(pages[k]);
            links = 0;
            visited = new ArrayList<>();

            while(hrefMatcher.find()){
                links += 1;
                String tmp = hrefMatcher.group(1);
                Integer visitIdx = dnsMap.get(tmp);
                if(visitIdx != null){
                    visited.add(visitIdx);
                }
            }

            // 3단계. 각 기본 점수를 가져와 외부 링크와의 채점 진행
            for(int idx : visited) {
                webs[idx].addScore((double) webs[k].word / links);
            }
        }

        // 최종단계. 최고 점수를 찾아 결과를 반환함.
        int res = 0;
        double max = Double.MIN_VALUE;
        for(int k=0;k<webs.length;k++){
            if(max < webs[k].score) {
                max = webs[k].score;
                res = k;
            }
        }

        return res;
    }

    public static void main(String[] args){
        String[] webTags1 = {
            "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>",
            "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>",
            "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"
        };

        String[] webTags2 = {
            "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
            "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"
        };

        System.out.println(solution("blind", webTags1));
        System.out.println(solution("Muzi", webTags2));
    }
}
