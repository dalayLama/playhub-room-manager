package com.playhub.roommanager.service.testbuilders;

import com.jimbeam.test.utils.common.TestObjectBuilder;
import com.jimbeam.test.utils.common.TestObjectBuilderUtils;
import com.playhub.roommanager.service.dao.entities.RoomEntity;
import com.playhub.roommanager.service.dao.entities.RoomParticipantEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(staticName = "aRoom")
@With
public class RoomEntityTestBuilder implements TestObjectBuilder<RoomEntity> {

    private UUID id = UUID.fromString("026fbd40-4e15-413d-a118-e63f85658c97");

    private UUID ownerId = UUID.fromString("428e8fac-af78-4d1f-af55-f9d6225d3111");

    private String securityCode = "code";

    private Integer maxParticipants = 10;

    private List<RoomParticipantEntity> participants = new ArrayList<>();

    private Instant createdAt = Instant.now();

    public static RoomEntityTestBuilder newRoom() {
        return new RoomEntityTestBuilder()
                .withId(null)
                .withCreatedAt(null);
    }

    @Override
    public RoomEntity build() {
        return TestObjectBuilderUtils.map(this, RoomEntity.class);
    }

}
