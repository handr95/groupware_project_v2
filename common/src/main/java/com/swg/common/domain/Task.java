package com.swg.common.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "TASK")
public class Task extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TASK_NO", nullable = false)
    private Long taskNo;
    @Column(name="TASK_TITLE", nullable = false)
    private String taskTitle;
    @Column(name="TASK_DESC", nullable = false)
    private String taskDesc;
    @LastModifiedDate
    @Column(name="START_DT")
    private LocalDateTime startDt;
    @CreatedDate
    @Column(name="END_DT")
    private LocalDateTime endDt;
    @Enumerated(EnumType.ORDINAL)
    @Column(name="STATE", nullable = false)
    private TaskState state;
    @ManyToOne
    @JoinColumn(name="PROJECT_NO")
    private Project project;
    @ManyToOne
    @JoinColumn(name="MANAGER_NO")
    private User user;

    public void setProject(Project project) {
        if (this.project != null) {
            this.project.getTaskList().remove(this);
        }
        this.project = project;
        this.project.getTaskList().remove(this);
    }

    public void setUser(User user) {
        this.user = user;
    }
}
