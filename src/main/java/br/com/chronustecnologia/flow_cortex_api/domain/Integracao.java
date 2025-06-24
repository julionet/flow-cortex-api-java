package br.com.chronustecnologia.flow_cortex_api.domain;

import java.time.LocalDateTime;

public class Integracao {
    private Long id;
    private String name;
    private String apiKey;
    private String organizationId;
    private String model;
    private double temperature;
    private int maxTokens;
    private double topP;
    private double frequencyPenalty;
    private double presencePenalty;
    private int timeoutSeconds;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean active;

    public Integracao() {
    }

    public Integracao(Long id, String name, String apiKey, String organizationId, String model, double temperature, int maxTokens, double topP, double frequencyPenalty, double presencePenalty, int timeoutSeconds, LocalDateTime createdAt, LocalDateTime updatedAt, boolean active) {
        this.id = id;
        this.name = name;
        this.apiKey = apiKey;
        this.organizationId = organizationId;
        this.model = model;
        this.temperature = temperature;
        this.maxTokens = maxTokens;
        this.topP = topP;
        this.frequencyPenalty = frequencyPenalty;
        this.presencePenalty = presencePenalty;
        this.timeoutSeconds = timeoutSeconds;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }

    public double getTopP() {
        return topP;
    }

    public void setTopP(double topP) {
        this.topP = topP;
    }

    public double getFrequencyPenalty() {
        return frequencyPenalty;
    }

    public void setFrequencyPenalty(double frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
    }

    public double getPresencePenalty() {
        return presencePenalty;
    }

    public void setPresencePenalty(double presencePenalty) {
        this.presencePenalty = presencePenalty;
    }

    public int getTimeoutSeconds() {
        return timeoutSeconds;
    }

    public void setTimeoutSeconds(int timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
