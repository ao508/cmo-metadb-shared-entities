package org.mskcc.cmo.shared.neo4j;

import java.util.List;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

/**
 *
 * @author ochoaa
 */
@Node("cmo_metadb_project")
public class CmoProjectEntity {
    @Id
    private String projectId;
    @Relationship(type = "PROJECT_TO_REQUEST", direction = Direction.OUTGOING)
    private List<CmoRequestEntity> cmoRequestList;

    public CmoProjectEntity() {}

    public CmoProjectEntity(String projectId, List<CmoRequestEntity> cmoRequestList) {
        this.projectId = projectId;
        this.cmoRequestList = cmoRequestList;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public List<CmoRequestEntity> getCmoRequestList() {
        return cmoRequestList;
    }

    public void setCmoRequestList(List<CmoRequestEntity> cmoRequestList) {
        this.cmoRequestList = cmoRequestList;
    }
}
