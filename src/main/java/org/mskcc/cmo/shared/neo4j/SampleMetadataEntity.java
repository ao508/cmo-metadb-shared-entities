package org.mskcc.cmo.shared.neo4j;

import org.mskcc.cmo.shared.SampleMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

//import org.neo4j.ogm.annotation.GeneratedValue;
//import org.neo4j.ogm.annotation.Id;
//import org.neo4j.ogm.annotation.NodeEntity;
//import org.neo4j.ogm.annotation.Relationship;
//import org.neo4j.ogm.annotation.typeconversion.Convert;
//import org.neo4j.ogm.id.UuidStrategy;
//import org.neo4j.ogm.typeconversion.UuidStringConverter;

@Node("cmo_metadb_sample_metadata")
public class SampleMetadataEntity extends SampleMetadata {
    @Id @GeneratedValue(UUIDStringGenerator.class)
    private UUID metaDbUuid;
    @Relationship(type="SP_TO_SP", direction=Direction.INCOMING)
    private List<Sample> linkedSampleList;
    @Relationship(type="PX_TO_SP", direction=Direction.INCOMING)
    private PatientMetadata patient;

    public SampleMetadataEntity() {
        super();
    }

    public SampleMetadataEntity(UUID metaDbUuid, String mrn, String cmoPatientId, String cmoSampleId, String igoId, String investigatorSampleId, String species,
                          String sex, String tumorOrNormal, String sampleType, String preservation, String tumorType, String parentTumorType,
                          String specimenType, String sampleOrigin, String tissueSource, String tissueLocation, String recipe,
                          String baitset, String fastqPath, String principalInvestigator, String ancestorSample, boolean doNotUse, String sampleStatus,
                          List<Sample> linkedSampleList, PatientMetadata patient) {
        super(mrn,
            cmoPatientId,
            cmoSampleId,
            igoId,
            investigatorSampleId,
            species,
            sex,
            tumorOrNormal,
            sampleType,
            preservation,
            tumorType,
            parentTumorType,
            specimenType,
            sampleOrigin,
            tissueSource,
            tissueLocation,
            recipe,
            baitset,
            fastqPath,
            principalInvestigator,
            ancestorSample,
            doNotUse,
            sampleStatus);
        this.metaDbUuid = metaDbUuid;
        this.linkedSampleList = linkedSampleList;
        this.patient = patient;
    }

    public UUID getMetaDbUuid() {
        return metaDbUuid;
    }

    public void setMetaDbUuid(UUID metaDbUuid) {
        this.metaDbUuid = metaDbUuid;
    }

    public List<Sample> getLinkedSampleList() {
        return linkedSampleList;
    }

    public void setLinkedSampleList(List<Sample> linkedSampleList) {
        this.linkedSampleList = linkedSampleList;
    }

    public void linkSample(Sample linkedSample) {
        if (linkedSampleList == null) {
            linkedSampleList = new ArrayList<>();
        }
        linkedSampleList.add(linkedSample);
    }

    public PatientMetadata getPatient() {
        return patient;
    }

    public void setPatient(PatientMetadata patient) {
        this.patient = patient;
    }

}
