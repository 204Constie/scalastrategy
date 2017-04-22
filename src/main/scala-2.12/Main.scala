

/**
  * Created by constie on 08.04.2017.
  */

import scala.io.Source
import net.liftweb.json._

trait Parser
case class CSVParser(input: Source) extends Parser
case class JSONParser(input: String) extends Parser


object Main {
  def parseInput[T <: Parser](fileType: T, parsingStrategy: (T => Unit)) = {
    parsingStrategy(fileType)
  }

  def parseCSV(bufferedSource: CSVParser): Unit = {
    for (line <- bufferedSource.input.getLines) {
      val cols = line.split(",").map(_.trim)
      println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
    }
    bufferedSource.input.close
  }

  def parseJSON(inputFile: JSONParser): Unit = {

    println(parse(inputFile.input))

  }

  def main(args: Array[String]): Unit = {

    val jsonSource = new JSONParser(io.Source.fromFile("./jsonfile.json").mkString)
    val csvSource = new CSVParser(io.Source.fromFile("./csvfile.csv"))

    parseInput(csvSource, parseCSV)
    parseInput(jsonSource, parseJSON)


  }
}
