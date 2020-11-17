package org.mskcc.cmo.shared.neo4j;

import java.io.Serializable;
import java.util.Collection;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

/**
 *
 * @author ochoaa
 */
//@RelationshipEntity(type="SP_TO_SP")
public class SampleToSampleEntity implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private Collection<String> linkedSampleNames;
//    @StartNode
    private Sample linkedSample;
//    @EndNode
    private SampleMetadataEntity sampleMetadata;

    public SampleToSampleEntity() {}

    public Collection<String> getLinkedSampleNames() {
        return linkedSampleNames;
    }

    public void setLinkedSampleNames(Collection<String> linkedSampleNames) {
        this.linkedSampleNames = linkedSampleNames;
    }

    public Sample getSample() {
        return linkedSample;
    }

    public void setSample(Sample sample) {
        this.linkedSample = sample;
    }

    public SampleMetadataEntity getSampleMetadata() {
        return sampleMetadata;
    }

    public void setSampleMetadata(SampleMetadataEntity sampleMetadata) {
        this.sampleMetadata = sampleMetadata;
    }

}
