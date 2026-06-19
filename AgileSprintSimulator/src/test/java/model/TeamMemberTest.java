package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TeamMemberTest {

    @Test
    void teamMemberPropertiesAreAccessible() {
        TeamMember member = new TeamMember("Jamie", "Tester", 12);

        assertEquals("Jamie", member.getName());
        assertEquals("Tester", member.getRole());
        assertEquals(12, member.getCapacity());
        assertTrue(member.toString().contains("Jamie"));
        assertTrue(member.toString().contains("Tester"));
        assertTrue(member.toString().contains("12"));
    }
}
