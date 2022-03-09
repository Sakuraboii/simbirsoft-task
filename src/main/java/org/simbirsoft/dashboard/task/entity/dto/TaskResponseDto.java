package org.simbirsoft.dashboard.task.entity.dto;

import org.simbirsoft.dashboard.task.entity.Status;
import org.simbirsoft.dashboard.user.entity.dto.UserResponseDto;

import java.util.Date;

public class TaskResponseDto {

    private Long id;

    private UserResponseDto author;

    private UserResponseDto executor;

    private Integer releaseVersion;

    private Status status;

    private Date registrationDate;

    private Date completionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserResponseDto getExecutor() {
        return executor;
    }

    public Integer getReleaseVersion() {
        return releaseVersion;
    }

    public Status getStatus() {
        return status;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public UserResponseDto getAuthor() {
        return author;
    }

    public void setAuthor(UserResponseDto author) {
        this.author = author;
    }

    public void setExecutor(UserResponseDto executor) {
        this.executor = executor;
    }

    public void setReleaseVersion(Integer releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }
}
