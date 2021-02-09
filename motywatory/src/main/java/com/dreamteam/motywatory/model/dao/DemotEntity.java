package com.dreamteam.motywatory.model.dao;

import com.dreamteam.motywatory.model.dto.VoteDTO.VoteCounter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.*;
import java.util.List;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "demot")
public class DemotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topText;

    @NotEmpty
    private String bottomText;

    @NotEmpty
    private String imagePath;

    @OneToMany
    private List<VoteEntity> voteId;


}
