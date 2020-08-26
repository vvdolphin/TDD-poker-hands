package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TDDPokerHansGameTest {

    private static TDDPokerHandsGame tddPokerHandsGame;

    @BeforeAll
    public static void setUp() throws Exception {
        tddPokerHandsGame = new TDDPokerHandsGame();
    }

    @Test
    void should_return_not_null_when_compare_given_2_cards(){
        String cards1 = "2H 3D KD 5S 4D";
        String cards2 = "2C 3H 8C AH 2D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertNotNull(result);
    }

    @Test
    void should_return_white_wins_with_high_card_and_ace_when_compare_given_2H_3D_KD_5S_TD_and_2C_3H_8C_AH_5D(){
        String cards1 = "2H 3D KD 5S TD";
        String cards2 = "2C 3H 8C AH 5D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with high card: A", result);
    }

    @Test
    void should_return_tie_when_compare_given_2H_5D_3D_KS_7S_and_KC_3H_5C_2H_7D(){
        String cards1 = "2H 5D 3D KS 7S";
        String cards2 = "KC 3H 5C 2H 7D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Tie", result);
    }

    @Test
    void should_return_white_wins_with_high_card_and_ace_when_compare_given_3C_2H_8C_KH_7D_and_3H_2D_5D_9S_KD(){
        String cards1 = "3C 2H 8C KH 7D";
        String cards2 = "3H 2D 5D 9S KD";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with high card: 9", result);
    }
}
