package com.siby.scalatest_examples.scalamock

import com.siby.scalatest_examples.scalamock.Countries.{China, India}
import org.scalamock.scalatest.MockFactory

class MatchResultObserverTest extends org.scalatest.FunSuite with MockFactory {

  test("update leaderboard") {

    // given
    val stubDb = stub[PlayerDatabase]
    val fakeBoard = mock[CountryLeaderboard]

    fakeBoard.addVictoryForCountry _ expects India

    val winner: Player = Player(1, "Siby", India)
    stubDb.getPlayerById _ when winner.id returns winner
    val loser: Player = Player(2, "Feng", China)

    val matchResultObserver: MatchResultObserver = new MatchResultObserver(stubDb, fakeBoard)

    // when
    matchResultObserver.recordMatchResult(new MatchResult(winner.id, loser.id))
  }
}
