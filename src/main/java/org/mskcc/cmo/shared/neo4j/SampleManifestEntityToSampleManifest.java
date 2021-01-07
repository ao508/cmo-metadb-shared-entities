package org.mskcc.cmo.shared.neo4j;

import java.io.Serializable;
import org.mskcc.cmo.shared.SampleManifest;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

/**
 *
 * @author ochoaa
 */
@RelationshipEntity(type = "SAMPLE_METADATA")
public class SampleManifestEntityToSampleManifest implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @StartNode
    private SampleManifestEntity sampleManifestEntity;
    @EndNode
    private SampleManifest sampleManifest;

    public SampleManifestEntityToSampleManifest() {}

    public SampleManifestEntity getSampleManifestEntity() {
        return sampleManifestEntity;
    }

    public void setSampleManifestEntity(SampleManifestEntity sampleManifestEntity) {
        this.sampleManifestEntity = sampleManifestEntity;
    }

    public SampleManifest getSampleManifest() {
        return sampleManifest;
    }

    public void setSampleManifest(SampleManifest sampleManifest) {
        this.sampleManifest = sampleManifest;
    }

}
