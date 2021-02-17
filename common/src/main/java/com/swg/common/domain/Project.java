package com.swg.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PROJECT")
public class Project  extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PROJECT_NO")
    private Long projectNo;
    @Column(name="PROJECT_TITLE", nullable = false)
    private String projectTitle;
    @Column(name="PROJECT_DESC", nullable = false)
    private String projectDesc;
    @Column(name="OPEN_YN", nullable = false)
    private Short openYn;
    @OneToMany(mappedBy = "project")
    @JoinColumn(name="PROJECT_NO", insertable = false)
    private List<Task> taskList = new ArrayList<>();
    @Builder
    public Project(Long projectNo, String projectTitle, String projectDesc, Short openYn) {
        this.projectNo = projectNo;
        this.projectTitle = projectTitle;
        this.projectDesc = projectDesc;
        this.openYn = openYn;
    }

}