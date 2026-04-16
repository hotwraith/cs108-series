package serie4;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public record LSystem(String string, Map<Character, String> rules, Set<Character> lineChars, int turningAngle) {

    public LSystem {
        rules = Map.copyOf(rules);
        lineChars = Set.copyOf(lineChars);
    }

    public LSystem(String string, Map<Character, String> rules, String lineChars, int turningAngle) {
        Set<Character> t = new TreeSet<>() {
        };
        for  (char c : lineChars.toCharArray()) {
            t.add(c);
        }
        this(string, rules, t, turningAngle);
    }

    public LSystem evolve() {
        StringBuilder sBuilder = new StringBuilder();
        for(Character c : string.toCharArray()) {
            if(rules.containsKey(c)) {
                sBuilder.append(rules.get(c));
            }
        }
        return new LSystem(sBuilder.toString(), rules, lineChars, turningAngle);
    }
    public LSystem evolve(int steps) {
        String temp = string;
        for(int i = 0; i<steps; i++) {
            StringBuilder sBuilder = new StringBuilder();
            for(Character c : temp.toCharArray()) {
                if(rules.containsKey(c)) {
                    sBuilder.append(rules.get(c));
                } else {
                    sBuilder.append(c);
                }
            }
            temp = sBuilder.toString();
        }
        return new LSystem(temp, rules, lineChars, turningAngle);
    }

}
