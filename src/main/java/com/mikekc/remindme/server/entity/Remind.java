package com.mikekc.remindme.server.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "remind")
@Data
public class Remind {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "remind_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date remindDate;

}
