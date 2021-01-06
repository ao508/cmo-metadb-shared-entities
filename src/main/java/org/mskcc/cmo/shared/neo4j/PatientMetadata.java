package org.mskcc.cmo.shared.neo4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.neo4j.ogm.annotation.typeconversion.Convert;
import org.neo4j.ogm.typeconversion.UuidStringConverter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

/**
 *
 * @author ochoaa
 */

@Node("cmo_metadb_patient_metadata")
public class PatientMetadata implements Serializable {
    @Id @GeneratedValue(UUIDStringGenerator.class)
    @Convert(UuidStringConverter.class)
    private UUID uuid;
    private String investigatorPatientId;
    @Relationship(type = "PX_TO_SP", direction = Direction.OUTGOING)
    private List<SampleManifestEntity> sampleManifestList;
    @Relationship(type = "PX_TO_NORMAL", direction = Direction.OUTGOING)
    private List<SampleManifestEntity> normalSampleManifestList;
    @Relationship(type = "PX_TO_PX", direction = Direction.INCOMING)
    private List<Patient>  patientList;

    public PatientMetadata() {}

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getInvestigatorPatientId() {
        return investigatorPatientId;
    }

    public void setInvestigatorPatientId(String investigatorPatientId) {
        this.investigatorPatientId = investigatorPatientId;
    }

    public List<SampleManifestEntity> getSampleManifestList() {
        return sampleManifestList;
    }

    public void setSampleManifestList(List<SampleManifestEntity> sampleManifestList) {
        this.sampleManifestList = sampleManifestList;
    }

    /**
     * Link a SampleManifest instance to this PatientMetadata.
     * @param sampleManifest
     */
    public void linkSampleManifest(SampleManifestEntity sampleManifest) {
        if (sampleManifestList == null) {
            sampleManifestList = new ArrayList<>();
        }
        sampleManifestList.add(sampleManifest);
    }

    public List<SampleManifestEntity> getNormalSampleManifestList() {
        return normalSampleManifestList;
    }

    public void setNormalSampleManifestList(List<SampleManifestEntity> normalSampleManifestList) {
        this.normalSampleManifestList = normalSampleManifestList;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> linkedPatientList) {
        this.patientList = linkedPatientList;
    }

    /**
     * Add patient to array list.
     * @param patient
     */
    public void addPatient(Patient patient) {
        if (patientList == null) {
            patientList = new ArrayList<>();
        }
        patientList.add(patient);
    }

}
