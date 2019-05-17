package com.stackroute.mashupcontent.comman;

import com.stackroute.mashupcontent.model.Player;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto {

    private Player player;

    private List<Player> playerList = new ArrayList();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
