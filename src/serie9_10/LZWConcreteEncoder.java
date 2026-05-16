package serie9_10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LZWConcreteEncoder implements LZWEncoder {
    private SortedSet<String> alphabet;
    private int capacity;

    public LZWConcreteEncoder(SortedSet<Character> alphabet, int capacity) {
        Iterator<Character> stream = alphabet.stream().iterator();
        this.alphabet = new TreeSet<String>();
        while (stream.hasNext()) {
            this.alphabet.add(stream.next().toString());
        }
        this.capacity = capacity;
    }

    @Override
    public List<Integer> encode(String s) {
        ArrayList<String> alpha = new ArrayList<>(alphabet);
        List<Integer> result = new ArrayList<Integer>();
        while (!s.isEmpty()) {
            String substring = "";
            for (int i = s.length(); i > -1; i--) {
                substring = s.substring(0, i);
                if (alpha.contains(substring)) {
                    if((alpha.size() < capacity)) {
                        alpha.add(substring + s.charAt(substring.length()));
                    }
                    result.add(alpha.indexOf(substring));
                    break;
                }
            }
            s = s.substring(substring.length(), s.length());
        }

        return result;
    }

}
