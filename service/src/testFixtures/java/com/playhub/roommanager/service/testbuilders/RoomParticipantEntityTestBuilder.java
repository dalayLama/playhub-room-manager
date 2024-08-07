package com.playhub.roommanager.service.testbuilders;

import com.jimbeam.test.utils.common.TestObjectBuilder;
import com.playhub.roommanager.dao.entities.RoomEntity;
import com.playhub.roommanager.dao.entities.RoomParticipantEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(staticName = "aParticipant")
@With
public class RoomParticipantEntityTestBuilder implements TestObjectBuilder<RoomParticipantEntity> {

    private Long id  = 1L;

    private RoomEntity room = RoomEntityTestBuilder.aRoom().build();

    private UUID participantId = UUID.randomUUID();

    private Instant addedAt = Instant.now();

    public static RoomParticipantEntityTestBuilder newParticipant() {
        return aParticipant()
                .withId(null)
                .withParticipantId(UUID.randomUUID())
                .withAddedAt(null);
    }

    public static RoomParticipantEntityTestBuilder aParticipant(RoomEntity room) {
        return aParticipant()
                .withRoom(room);
    }

    @Override
    public RoomParticipantEntity build() {
        RoomParticipantEntity participant = new RoomParticipantEntity(id, null, participantId, addedAt);
        if (room != null) {
            room.addParticipant(participant);
        }
        return participant;
    }
}
