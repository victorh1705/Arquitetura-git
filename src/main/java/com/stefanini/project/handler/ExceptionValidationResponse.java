package com.stefanini.project.handler;

import java.util.ArrayList;
import java.util.List;

public class ExceptionValidationResponse {
    private String title;
    private int status;
    private List<ErrorDetail> detail;
    private long timestamp;
    private String developerMessage;

    public ExceptionValidationResponse(String title, int status, List<ErrorDetail> detail,
            long timestamp, String developerMessage) {
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.timestamp = timestamp;
        this.developerMessage = developerMessage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ErrorDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<ErrorDetail> detail) {
        this.detail = detail;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }


    public static final class Builder {
        private String title;
        private int status;
        private List<ErrorDetail> detail;
        private long timestamp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(List<ErrorDetail> detail) {
            this.detail = detail;
            return this;
        }

        public Builder addDetail(ErrorDetail detail) {
            if (this.detail == null) {
                this.detail = new ArrayList<>();
            }
            this.detail.add(detail);
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ExceptionValidationResponse build() {
            return new ExceptionValidationResponse(title, status, detail, timestamp,
                    developerMessage);
        }
    }
}
