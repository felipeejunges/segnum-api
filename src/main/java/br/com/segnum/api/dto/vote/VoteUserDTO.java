package br.com.segnum.api.dto.vote;

import br.com.segnum.api.domain.Vote;
import br.com.segnum.api.dto.event.EventSimplifyDTO;
import br.com.segnum.api.dto.user.UserSimplifyDTO;

public class VoteUserDTO {

    private int id;
    private boolean upVote;
    private String reason;
    private EventSimplifyDTO event;

    public VoteUserDTO() {
    }

    public VoteUserDTO(Vote vote) {
        this.id = vote.getId();
        this.upVote = vote.isUpVote();
        this.reason = vote.getReason();
        if (vote.getEvent() != null) this.event = new EventSimplifyDTO(vote.getEvent());
    }

    public VoteUserDTO(int id, boolean upVote, String reason, EventSimplifyDTO event, UserSimplifyDTO user) {
        this.id = id;
        this.upVote = upVote;
        this.reason = reason;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isUpVote() {
        return upVote;
    }

    public void setUpVote(boolean upVote) {
        this.upVote = upVote;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public EventSimplifyDTO getEvent() {
        return event;
    }

    public void setEvent(EventSimplifyDTO event) {
        this.event = event;
    }
}
