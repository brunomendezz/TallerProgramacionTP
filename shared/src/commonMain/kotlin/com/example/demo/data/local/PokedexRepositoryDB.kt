import com.example.demo.DatabaseDriverFactory
import com.example.demo.data.model.PokedexResults
import com.poke.db.AppDatabase

class PokedexRepositoryDB( private val databaseDriverFactory: DatabaseDriverFactory) {


    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.pokeQueries


    fun insertPokedexs(pokedexs: List<PokedexResults>) {
        dbQuery.transaction {
            pokedexs.forEach{ poke ->
                dbQuery.insertCharacter(
                    name = poke.name,
                    url = poke.url
                )
            }
        }
    }

    fun get() : List<PokedexResults> {
        val results : List<PokedexResults> = dbQuery.getCharacter() {
                name, url ->  PokedexResults(name, url)
        }.executeAsList()

        return results
    }


}