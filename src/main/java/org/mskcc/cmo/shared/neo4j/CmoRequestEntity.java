package org.mskcc.cmo.shared.neo4j;

import java.util.List;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

/**
 *
 * @author ochoaa
 */
@Node("cmo_metadb_request")
public class CmoRequestEntity {
    @Id @GeneratedValue
    private Long id;
    private String requestId;
    @Relationship(type = "PROJECT_TO_REQUEST", direction = Direction.INCOMING)
    private CmoProjectEntity cmoProject;
    @Relationship(type = "REQUEST_TO_SP", direction = Direction.OUTGOING)
    private List<SampleManifestEntity> sampleManifestList;
    private String requestJson;

    public CmoRequestEntity() {}

    public CmoRequestEntity(String requestId, List<SampleManifestEntity> sampleManifestList, String requestJson) {
        this.requestId = requestId;
        this.sampleManifestList = sampleManifestList;
        this.requestJson = requestJson;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public CmoProjectEntity getCmoProject() {
        return cmoProject;
    }

    public void setCmoProject(CmoProjectEntity cmoProject) {
        this.cmoProject = cmoProject;
    }

    public List<SampleManifestEntity> getSampleManifestList() {
        return sampleManifestList;
    }

    public void setSampleManifestList(List<SampleManifestEntity> sampleManifestList) {
        this.sampleManifestList = sampleManifestList;
    }

    public String getRequestJson() {
        return requestJson;
    }

    public void setRequestJson(String requestJson) {
        this.requestJson = requestJson;
    }

}
