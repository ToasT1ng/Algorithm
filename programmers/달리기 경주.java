import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> orderMap = new HashMap<>();
        Map<String, Integer> playerMap = new HashMap<>();
        for (int i=0 ; i<players.length ; i++) {
            orderMap.put(i, players[i]);
            playerMap.put(players[i], i);
        }

        for (String calling : callings) {
            int playerIndex = playerMap.get(calling);

            if (playerIndex == 0) {
                continue;
            }

            String switchingPlayer = orderMap.get(playerIndex-1);

            orderMap.put(playerIndex, switchingPlayer);
            orderMap.put(playerIndex-1, calling);

            playerMap.put(calling, playerIndex-1);
            playerMap.put(switchingPlayer, playerIndex);
        }
        
        String[] answer = new String[players.length];
        for (int i=0 ; i<players.length ; i++) {
            answer[i] = orderMap.get(i);
        }
        return answer;
    }
}
