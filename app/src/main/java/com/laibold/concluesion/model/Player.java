package com.laibold.concluesion.model;

/**
 * A Player is Participant of a {@link Game}
 */
public class Player {
    private String name;
    private boolean isAppUser;

    /**
     * Creates new Player
     *
     * @param name Name of the Player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return Name of the Player
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Name of the Player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns if Player is the person who is using the app
     *
     * @return Boolean
     */
    public boolean isAppUser() {
        return isAppUser;
    }

    /**
     * Sets if Player is appUser
     *
     * @param appUser true if Player is the person who is using the app
     */
    public void setAppUser(boolean appUser) {
        isAppUser = appUser;
    }
}
