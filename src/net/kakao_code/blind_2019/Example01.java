package net.kakao_code.blind_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Kakao 2019 블라인드 문제 1번
// 오픈 채팅방
public class Example01 {
    static final String ENTERING = "Enter";
    static final String LEAVING = "Leave";
    static final String CHANGING = "Change";

    static Map<String, Integer> userMap = new HashMap<>();
    static List<User> userList = new ArrayList<>();

    static class User {
        int no;
        String id;
        String name;
        public User(int no, String id, String name){
            this.no = no;
            this.id = id;
            this.name = name;
        }
        public void setName(String name){
            this.name = name;
        }
    }

    static class Message {
        User user;
        String status;
        public Message(User user, String status){
            this.user = user;
            this.status = status;
        }
        public String print(){
            switch(this.status){
                case ENTERING :
                    return String.format("%s님이 들어왔습니다.", this.user.name);
                case LEAVING :
                    return String.format("%s님이 나갔습니다.", this.user.name);
            }
            return null;
        }
    }

    static void update(int no, String userName){
        User user = userList.get(no);
        user.setName(userName);
        userList.set(no, user);
    }

    static String[] solution(String[] records){
        List<Message> messages = new ArrayList<>();
        for(String query : records){
            User user;
            String[] info = query.split("\\s");
            Integer key = userMap.get(info[1]);

            if(key != null){
                user = userList.get(key);
            } else {
                user = new User(userList.size(), info[1], info[2]);
                userMap.put(info[1], userList.size());
                userList.add(user);
            }

            if(info[0].equals(CHANGING)){
                update(user.no, info[2]);
            }

            else {
                if(info[0].equals(ENTERING)){
                    if(!user.name.equals(info[2]))
                        update(user.no, info[2]);
                }
                messages.add(new Message(user, info[0]));
            }
        }

        String[] result = new String[messages.size()];

        for(int k=0;k<result.length;k++){
            result[k] = messages.get(k).print();
        }

        return result;
    }

    public static void main(String[] args){
        String[] records = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(records)));
    }
}
