package com.dreamteam.motywatory.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private VOTE_TYPE vote;

    public enum VOTE_TYPE {
        VOTE_UP("+"),
        VOTE_DOWN("-");

        private final String text;

        private VOTE_TYPE(String plusOrMinus) {
            this.text = plusOrMinus;
        }
    }

    @ManyToOne
    private DemotEntity demotId;

}
