package org.simbirsoft.dashboard.task.entity;

import org.hibernate.annotations.GenericGenerator;
import org.simbirsoft.dashboard.user.entity.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SIMBIRSOFT_TASK")
public class Task{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne
    private User author;

    @ManyToOne
    private User executor;

    @Column(name = "release_version")
    private Integer releaseVersion;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "completion_date")
    private Date completionDate;

    public Task(User author,
                User executor,
                Integer releaseVersion,
                Status status,
                Date registrationDate,
                Date completionDate){
        this.author =author;
        this.executor =executor;
        this.releaseVersion = releaseVersion;
        this.status = status;
        this.completionDate = completionDate;
        this.registrationDate = registrationDate;
    }

    public Task(){}

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public Integer getReleaseVersion() {
        return releaseVersion;
    }

    public Status getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public User getExecutor() {
        return executor;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setReleaseVersion(Integer releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
