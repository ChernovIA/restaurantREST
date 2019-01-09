package com.votes.myRestaurant.dto;

public class VoteDTO {

    private String response;

    public VoteDTO(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
