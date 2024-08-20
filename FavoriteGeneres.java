import java.util.*;

public class FavoriteGeneres {
    public static Map<String, List<String>> findFavGeneres
            (Map<String, List<String>> userSongs, Map<String, List<String>> songGeneres) {
        // Song to Genere map
        HashMap<String, String> songToGenere = new HashMap<>();
        //Iterate through songGeneres and create song to genere
        for (String genere : songGeneres.keySet()) {
            List<String> allSongs = songGeneres.get(genere);
            for (String song : allSongs) {
                songToGenere.put(song, genere);
            }
        }
        // Iterate through all the users and fetch their songs from userSongs and for each song get the genere, count the frequency of each genere, record the max frequency and  create userGeneres result
        HashMap<String, List<String>>result = new HashMap<>();
        for(String user: userSongs.keySet()){
            HashMap<String, Integer> freqMap = new HashMap<>();
            int max =0;
            List<String> allSongs = userSongs.get(user);
            for(String song: allSongs){
                String genere = songToGenere.get(song);
                freqMap.put(genere,freqMap.getOrDefault(genere, 0) +1);
                max = Math.max(max, freqMap.get(genere));
            }
            result.put(user, new ArrayList<>());
            for(String key: freqMap.keySet()){
                if(max== freqMap.get(key)){
                    result.get(user).add(key);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();
        HashMap<String, List<String>> songGeneres = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));
        userSongs.put("Kimberly", Arrays.asList("song1", "song6", "song7"));
        userSongs.put("Emma", Arrays.asList("song4", "song6", "song9"));
        songGeneres.put("Rock", Arrays.asList("song1", "song3"));
        songGeneres.put("Dubstep", Arrays.asList("song7"));
        songGeneres.put("Techno", Arrays.asList("song2", "song4"));
        songGeneres.put("Pop", Arrays.asList("song5", "song6"));
        songGeneres.put("Jazz", Arrays.asList("song8", "song9"));
        System.out.println(findFavGeneres(userSongs, songGeneres));

    }
}
