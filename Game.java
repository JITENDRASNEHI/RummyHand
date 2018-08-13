package RummyHand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {

    public static HashMap<Integer, ArrayList<Card>> generateSeqMap (ArrayList<Card> handCard){
        HashMap <Integer, ArrayList<Card>> seqMap = new HashMap<Integer, ArrayList<Card>>();
        for(int i =0; i<handCard.size(); i++){
            if(seqMap.containsKey(handCard.get(i).getSuit())){
                ArrayList<Card> cards = seqMap.get(handCard.get(i).getSuit());
                cards.add(handCard.get(i));
                seqMap.put(handCard.get(i).getSuit(),cards);
            }
            else
            {
                ArrayList<Card> cards = new ArrayList<>();
                cards.add(handCard.get(i));
                seqMap.put(handCard.get(i).getSuit(),cards);
            }
        }

        return seqMap;
    }

    public static HashMap<Integer, ArrayList<Card>> generateSetMap (ArrayList<Card> handCard){
        HashMap <Integer, ArrayList<Card>> setMap = new HashMap<Integer, ArrayList<Card>>();
        for(int i =0; i<handCard.size(); i++){
            if(setMap.containsKey(handCard.get(i).getRank())){
                ArrayList<Card> cards = setMap.get(handCard.get(i).getRank());
                cards.add(handCard.get(i));
                setMap.put(handCard.get(i).getRank(),cards);
            }
            else
            {
                ArrayList<Card> cards = new ArrayList<>();
                cards.add(handCard.get(i));
                setMap.put(handCard.get(i).getRank(),cards);
            }
        }

        return setMap;
    }


    public static  ArrayList<ArrayList<Card>>  generateSequences(HashMap<Integer,ArrayList<Card>> seqMap, int min){
        ArrayList<ArrayList<Card>> sequences = new ArrayList<>();
        ArrayList<Card> sequence = new ArrayList<>();
        for(int j=1; j<=seqMap.size(); j++) {
            ArrayList<Card> hand = seqMap.get(j);
            for(int i=1;i<hand.size(); i++) {
                if (hand.get(i).getSuit() == hand.get(i - 1).getSuit() &&
                        (hand.get(i).getRank() - hand.get(i - 1).getRank()) == 1) {
                    sequence.add(hand.get(i - 1));
                    if (hand.get(i).getRank() == 13) {
                        int k = i;
                        while (hand.get(k).getSuit() == hand.get(i).getSuit()) {
                            k--;
                            if (hand.get(k).getRank() == 1) {
                                sequence.add(hand.get(k));
                            }
                        }
                    }
                    if (i == hand.size() - 1) {
                        sequence.add(hand.get(i));
                        sequences.add(sequence);
                    }
                } else {
                    sequence.add(hand.get(i - 1));
                    if (sequence.size() >= min) {
                        sequences.add(sequence);
                    }
                    sequence = new ArrayList<>();
                }
            }
        }
        return sequences;
    }


    public static  ArrayList<ArrayList<Card>>  generateSets(HashMap<Integer,ArrayList<Card>> setMap, int min) {

        ArrayList<ArrayList<Card>> sets = new ArrayList<>();
        ArrayList<Card> set = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Card>> entry : setMap.entrySet()) {
            ArrayList<Card> hand = entry.getValue();
            for (int i = 1; i < hand.size(); i++) {
                if (hand.get(i).getRank() == hand.get(i - 1).getRank()) {
                    set.add(hand.get(i - 1));
                    if (i == hand.size() - 1) {
                        set.add(hand.get(i));
                        sets.add(set);
                        set = new ArrayList<>();
                    }
                } else {
                    set.add(hand.get(i - 1));
                    if (set.size() >= min) {
                        sets.add(set);
                    }
                    set = new ArrayList<>();
                }
            }
        }
        return sets;
    }
    public static void main (String args[]){
        Card c1 = new Card(1,2);
        Card c2 = new Card(1,3);
        Card c3 = new Card(1,4);
        Card c4 = new Card(2,5);
        Card c5 = new Card(3,5);
        Card c6 = new Card(4,5);
        Card c7 = new Card(1,7);
        Card c8 = new Card(1,7);
        Card c9 = new Card(1,7);
        Card c10 = new Card(3,6);
        Card c11 = new Card(3,7);
        Card c12 = new Card(3,8);
        Card c13 = new Card(2,9);


        ArrayList<Card> handCard = new ArrayList<Card>();
        handCard.add(c1);
        handCard.add(c2);
        handCard.add(c3);
        handCard.add(c4);
        handCard.add(c5);
        handCard.add(c6);
        handCard.add(c7);
        handCard.add(c8);
        handCard.add(c9);
        handCard.add(c10);
        handCard.add(c11);
        handCard.add(c12);
        handCard.add(c13);
        HashMap<Integer,ArrayList<Card>> seqMap;
        HashMap<Integer, ArrayList<Card>> setMap;
        seqMap = generateSeqMap(handCard);
        for(Map.Entry<Integer,ArrayList<Card>> entry : seqMap.entrySet()){
            System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>");
        setMap = generateSetMap(handCard);
        for(Map.Entry<Integer,ArrayList<Card>> entry : setMap.entrySet()){
            System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>");
        ArrayList<ArrayList<Card>> sequences = generateSequences(seqMap,3);
        for(int i=0;i<sequences.size();i++){
            ArrayList<Card> sequence = sequences.get(i);
            System.out.println(sequence);
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>");
        ArrayList<ArrayList<Card>> sets = generateSets(setMap,3);
        for(int i=0;i<sets.size();i++){
            ArrayList<Card> set = sets.get(i);
            System.out.println(set);
        }

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>");
//        for(Map.Entry<Integer,ArrayList<Card>> entry : seqMap.entrySet()){
//            System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());
//        }
    }
}