package y2016

import org.scalatest.FunSuite
import y2016.day04_1.{calculate, isRealRoom, mapToRoomId, roomId}

class day04_1Test  extends FunSuite {

  test("Determine result") {
    assert(calculate(Array("aaaaa-bbb-z-y-x-123[abxyz]", "a-b-c-d-e-f-g-h-987[abcde]", "not-a-real-room-404[oarel]", "totally-real-room-200[decoy]")) == 1514)
  }

  test("regex for string to roomId transformation") {
    assert(mapToRoomId("aaaaa-bbb-z-y-x-123[abxyz]") == roomId("aaaaa-bbb-z-y-x", 123, "abxyz"))
    assert(mapToRoomId("a-b-c-d-e-f-g-h-987[abcde]") == roomId("a-b-c-d-e-f-g-h", 987, "abcde"))
    assert(mapToRoomId("not-a-real-room-404[oarel]") == roomId("not-a-real-room", 404, "oarel"))
    assert(mapToRoomId("totally-real-room-200[decoy]") == roomId("totally-real-room", 200, "decoy"))
  }
  test("Check if room is a real room") {
    assert(isRealRoom(roomId("aaaaa-bbb-z-y-x", 123, "abxyz")))
    assert(isRealRoom(roomId("a-b-c-d-e-f-g-h", 987, "abcde")))
    assert(isRealRoom(roomId("not-a-real-room", 404, "oarel")))
    assert(!isRealRoom(roomId("totally-real-room", 200, "decoy")))
  }
}
