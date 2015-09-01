package com.siby.scalatest_examples.scalamock

object Countries extends Enumeration {
  val India, China = Value
}

import Countries.{Value => Country}
case class Player(id: Int, name: String, country: Country)

case class MatchResult(winner: Int, loser: Int)

case class CountryLeaderboardEntry(country: Country, points: Int)

trait CountryLeaderboard {
  def addVictoryForCountry(country: Country)

  def getTopCountries: List[CountryLeaderboardEntry]
}

trait PlayerDatabase {
  def getPlayerById(id: Int): Player
}

class MatchResultObserver(playerDatabase: PlayerDatabase, countryLeaderboard: CountryLeaderboard) {
  def recordMatchResult(matchResult: MatchResult) = {
    val winner: Player = playerDatabase.getPlayerById(matchResult.winner)
    countryLeaderboard addVictoryForCountry winner.country
  }

}

