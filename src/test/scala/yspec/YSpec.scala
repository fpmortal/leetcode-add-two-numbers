package yspec

import java.io.InputStream

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import org.json4s.native.Serialization.read
import org.json4s.{DefaultFormats, Formats}

object YSpec {

  private implicit val formats: Formats = DefaultFormats

  def fromResource[I: Manifest, O: Manifest](resource: String): YSpec[I, O] =
    load(ClassLoader.getSystemResourceAsStream(resource))

  private def load[I: Manifest, O: Manifest](is: InputStream): YSpec[I, O] = {
    read[YSpec[I, O]](
      new ObjectMapper().writeValueAsString(
        new ObjectMapper(new YAMLFactory()).readValue(
          scala.io.Source.fromInputStream(is).mkString,
          classOf[Any]
        )
      )
    )
  }
}

case class YSpec[I, O](cases: List[TestCase[I, O]])

case class TestCase[I, O](id: String, input: I, output: O)
