package org.simbirsoft.dashboard.task.entity.dto;

import org.simbirsoft.dashboard.task.entity.Status;

import java.util.Date;

public class TaskRequestDto {
    Long authorId;
    Long executorId;
    Integer releaseVersion;
    Status status;
    Date registrationDate;
    Date completionDate;

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setReleaseVersion(Integer releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getReleaseVersion() {
        return releaseVersion;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getExecutorId() {
        return executorId;
    }

    public void setExecutorId(Long executorId) {
        this.executorId = executorId;
    }
}
