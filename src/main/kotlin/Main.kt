import kotlin.random.Random
fun main() {
    // Get a random word.
    var word = randomWord()

    // Turn each letter to datatype Letter and add them to a list.
    val letters = mutableListOf<Letter>()
    for (character in word)
    {
        var newLetter = Letter(character)
        letters.add(newLetter)
    }

    var errorCounter = 0
    var guesses = mutableListOf<Char>()

    // Game loop. Continues until user guesses every letter or the stickman is created.
    while(!allVisible(letters) && errorCounter < 6) {
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
        displayGuesses(guesses)
        createStickman(errorCounter)
        displayWord(letters)
        println()
        var guess = guess(letters)
        guesses.add(guess)
        if (!errorCounter(guess, letters)) {
            errorCounter += 1
        }


    }
    println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
    createStickman(errorCounter)
    displayWord(letters)
    println("")
    if (allVisible(letters)){
        println("Great Job!")
    } else {
        println("Nice Try! The secret word was $word.")
    }
}

// Function for user's guess.
fun guess(letters: List<Letter>): Char{
    print("Guess a letter: ")
    var userInput = readLine() ?: " "
    var userInputChar = userInput.get(0)

    for (letter in letters)
    {
        if (userInputChar == letter.letter)
        {
            letter.hidden = false
        }
    }
    return userInput.get(0)
}

// Function to display letters, whether they are hidden or not.
fun displayWord(letters: List<Letter>) {
    for (letter in letters)
    {
        letter.GetRenderedText()
    }
}

// Check if all letters have been guessed.
fun allVisible(letters: List<Letter>): Boolean {
    for (letter in letters)
    {
        if (letter.hidden != false)
        {
            return false
        }
    }
    return true
}

// Keeps track of the number of wrong guesses.
fun errorCounter (guess: Char, letters: List<Letter>): Boolean {
    for (letter in letters) {
        if (guess == letter.letter) {
            return true
        }
    }
    return false
}

// Show the user the guesses.
fun displayGuesses(letters: List<Char>) {
    println("Guesses: $letters")
}

// Function that creates the stickman.
fun createStickman(wrongGuesses: Int) {

    if (wrongGuesses == 0) {
        println("      ______")
        println("     |      |")
        println("     |       ")
        println("     |       ")
        println("     |     ")
        println("_____|_____     ")
    } else if (wrongGuesses == 1) {
        println("      ______")
        println("     |      |")
        println("     |      @ ")
        println("     |       ")
        println("     |     ")
        println("_____|_____     ")
    } else if (wrongGuesses == 2) {
        println("      ______")
        println("     |      |")
        println("     |      @ ")
        println("     |      |  ")
        println("     |     ")
        println("_____|_____     ")
    } else if (wrongGuesses == 3) {
        println("      ______")
        println("     |      |")
        println("     |      @ ")
        println("     |     /|  ")
        println("     |     ")
        println("_____|_____     ")
    } else if (wrongGuesses == 4) {
        println("      ______")
        println("     |      |")
        println("     |      @ ")
        println("     |     /|\\  ")
        println("     |     ")
        println("_____|_____     ")
    } else if (wrongGuesses == 5) {
        println("      ______")
        println("     |      |")
        println("     |      @ ")
        println("     |     /|\\  ")
        println("     |     /")
        println("_____|_____     ")
    } else if (wrongGuesses >= 6) {
        println("      ______")
        println("     |      |")
        println("     |      @ ")
        println("     |     /|\\  ")
        println("     |     / \\")
        println("_____|_____     ")
    }
}

// Get a random word for the user to guess from the word_list.
fun randomWord(): String
{
    val word_list = arrayOf("tennis", "computer", "sports", "picture", "backpack", "cellphone", "chair",
    "animal", "battery", "keyboard", "suitcase", "pants", "hanger", "basket", "nation",
    "package", "games", "yellow", "orange", "purple", "deodorant", "beans", "llama",
    "alpaca", "frog", "goat", "pineapple", "guacomole", "papaya", "apple", "teeth", "porcupine",
    "turtle", "olive", "people", "history", "world", "information", "energy", "communication",
    "family", "government", "health", "system", "computer", "thanks", "music",
    "person", "reading", "method", "understanding", "theory", "night", "chemistry",
    "literature", "problem", "software", "control", "knowledge", "power", "ability", "economics",
    "internet", "television", "science", "library", "nature", "product",
    "temperature", "investment", "area", "society", "activity", "story", "industry", "media",
    "thing", "oven", "community", "definition", "safety", "quality", "development", "language",
    "management", "player", "variety", "video", "week", "security", "country", "exam", "movie",
    "organization", "equipment", "physics", "analysis", "policy", "series", "thought", "basis",
    "boyfriend", "direction", "strategy", "technology", "army", "camera", "freedom", "paper",
    "environment", "child", "instance", "month", "truth", "marketing", "university", "writing",
    "article", "department", "difference", "goal", "news", "audience", "fishing", "growth", "income",
    "marriage", "user", "combination", "failure", "meaning", "medicine", "philosophy", "teacher",
    "disease", "advertising", "location", "success", "addition", "apartment", "education", "moment",
    "painting", "politics", "attention", "decision", "property", "student", "competition",
    "distribution", "entertainment", "office", "population", "president", "category", "cigarette",
    "context", "introduction", "opportunity", "performance", "driver", "flight", "length", "magazine",
    "newspaper", "relationship", "teaching", "dealer", "member", "message", "appearance",
    "association", "concept", "customer", "discussion", "housing", "inflation", "insurance", "advice",
    "effort", "expression", "importance", "opinion", "payment", "reality", "responsibility", "situation",
    "statement", "wealth", "application", "county", "estate", "foundation", "grandmother", "perspective",
    "recipe", "studio", "collection", "depression", "imagination", "passion", "percentage", "resource",
    "setting", "agency", "college", "connection", "criticism", "description", "memory", "patience",
    "secretary", "solution", "administration", "aspect", "attitude", "director", "personality",
    "psychology", "recommendation", "response", "selection", "storage", "version", "alcohol", "argument",
    "complaint", "contract", "emphasis", "highway", "membership", "possession", "preparation", "agreement",
    "cancer", "currency", "employment", "engineering", "interaction", "mixture", "preference", "region",
    "republic", "tradition", "classroom", "delivery", "device", "difficulty", "election", "engine", "football",
    "guidance", "priority", "protection", "suggestion", "tension", "variation", "anxiety", "atmosphere",
    "awareness", "candidate", "climate", "comparison", "confusion", "construction", "elevator", "emotion",
    "employee", "employer", "height", "leadership", "manager", "operation", "recording", "sample",
    "transportation", "charity", "cousin", "disaster", "editor", "efficiency", "excitement", "extent",
    "feedback", "guitar", "homework", "leader", "outcome", "permission", "presentation", "promotion",
    "reflection", "refrigerator", "resolution", "revenue", "session", "singer", "tennis", "basket", "cabinet",
    "childhood", "church", "clothes", "coffee", "dinner", "drawing", "hearing", "initiative", "judgment",
    "measurement", "orange", "poetry", "police", "possibility", "procedure", "relation", "restaurant",
    "satisfaction", "sector", "signature", "significance", "vehicle", "volume", "accident", "airport",
    "appointment", "arrival", "assumption", "baseball", "chapter", "committee", "conversation", "database",
    "enthusiasm", "explanation", "farmer", "historian", "hospital", "injury", "instruction", "maintenance",
    "manufacturer", "perception", "presence", "proposal", "reception", "replacement", "revolution", "speech",
    "village", "warning", "winner", "worker", "writer", "assistance", "breath", "chocolate", "conclusion",
    "contribution", "cookie", "courage", "drawer", "establishment", "examination", "garbage", "grocery",
    "impression", "improvement", "independence", "insect", "inspection", "inspector", "ladder", "penalty",
    "potato", "profession", "professor", "quantity", "reaction", "requirement", "sister", "supermarket",
    "tongue", "weakness", "wedding", "affair", "ambition", "analyst", "assignment", "assistant", "bathroom",
    "bedroom", "birthday", "celebration", "championship", "client", "consequence", "departure", "diamond",
    "fortune", "friendship", "funeral", "girlfriend", "indication", "intention", "midnight", "negotiation",
    "obligation", "passenger", "platform", "pollution", "recognition", "reputation", "speaker", "stranger",
    "surgery", "sympathy", "throat", "trainer", "example", "business", "number", "process", "experience",
    "economy", "market", "interest", "course", "company", "training", "school", "amount", "practice",
    "research", "service", "answer", "matter", "picture", "access", "garden", "reason", "future", "demand",
    "exercise", "action", "record", "result", "section", "building", "nothing", "period", "subject", "weather",
    "chance", "figure", "source", "beginning", "program", "chicken", "design", "feature", "material", "purpose",
    "question", "object", "profit", "inside", "outside", "standard", "exchange", "position", "pressure", "stress",
    "advantage", "benefit", "review", "screen", "structure", "account", "discipline", "medium", "balance", "bottom",
    "choice", "impact", "machine", "address", "average", "career", "culture", "morning", "condition", "contact",
    "credit", "network", "square", "attempt", "effect", "capital", "challenge", "friend", "couple", "debate",
    "function", "living", "plastic", "summer", "button", "desire", "influence", "notice", "damage", "distance",
    "feeling", "savings", "target", "animal", "author", "budget", "discount", "ground", "lesson", "minute",
    "officer", "reference", "register", "trouble", "bridge", "campaign", "character", "evidence", "letter",
    "maximum", "option", "plenty", "quarter", "weight", "background", "factor", "master", "muscle", "strength",
    "traffic", "vegetable", "appeal", "kitchen", "mother", "principle", "relative", "season", "signal", "spirit",
    "street", "commission", "minimum", "progress", "project", "status", "ticket", "breakfast", "confidence",
    "daughter", "degree", "doctor", "father", "finance", "stable", "substance", "afternoon", "consideration",
    "detail", "interview", "mission", "pleasure", "shower", "window", "calendar", "contest", "corner",
    "district", "finger", "garage", "guarantee", "implement", "lecture", "manner", "meeting", "partner",
    "profile", "respect", "routine", "schedule", "telephone", "winter", "airline", "battle", "bother",
    "designer", "dimension", "emergency", "evening", "extension", "holiday", "horror", "husband", "mistake",
    "mountain", "occasion", "package", "patient", "phrase", "relief", "sentence", "shoulder", "stomach", "string",
    "tourist", "vacation", "associate", "border", "branch", "breast", "brother", "document", "expert", "landscape",
    "league", "native", "opening", "parent", "pattern", "request", "salary", "shelter", "silver", "tackle", "assist",
    "closet", "collar", "comment", "conference", "jacket", "monitor", "mortgage", "reward", "sandwich", "surprise",
    "transition", "weekend", "welcome", "bicycle", "bottle", "candle", "concert", "counter", "flower", "grandfather",
    "lawyer", "leather", "mirror", "pension", "purple", "specialist", "stroke", "switch", "bitter", "carpet",
    "champion", "channel", "comfort", "engineer", "entrance", "highlight", "incident", "island", "passage", "priest",
    "promise", "resident", "resort", "scheme", "script", "station", "witness", "public", "general", "specific",
    "tonight", "common", "change", "simple", "possible", "particular", "personal", "current", "national", "natural",
    "physical", "second", "increase", "single", "individual", "potential", "professional", "international", "travel",
    "alternative", "special", "excuse", "commercial", "purchase", "primary", "necessary",
    "positive", "produce", "search", "present", "creative", "support", "remove", "return", "complex", "effective",
    "middle", "regular", "reserve", "independent", "original", "beautiful", "charge", "active", "negative", "visual",
    "affect", "report", "beyond", "junior", "unique", "anything", "classic", "private", "western", "concern", "familiar",
    "official", "comfortable", "listen", "valuable", "handle", "release", "finish", "normal", "secret", "spread",
    "spring", "display", "objective", "cancel", "chemical", "extreme", "conflict", "formal", "opposite", "remote", "deposit",
    "somewhere", "advance", "anywhere", "consist", "double", "internal", "sensitive", "attack", "constant", "wonder", "annual",
    "forever", "impress", "nobody", "repeat", "whereas", "combine", "command", "divide", "equivalent", "initial", "mention",
    "spiritual", "survey", "escape", "gather", "repair", "scratch", "strike", "employ", "external", "illegal", "mobile",
    "ordinary", "respond", "senior", "strain", "struggle", "convert", "dependent", "permit", "recover", "resolve", "suspect",
    "upstairs", "abroad", "concentrate", "estimate", "prompt", "refuse", "regret", "reveal", "surround", "anybody", "brilliant",
    "female", "inevitable", "invite", "representative", "resist", "stretch", "stupid", "temporary", "tomorrow", "yesterday"
    )
    val randomValues = (0..830).random()
    return word_list[randomValues]
}