package com.example.mangatoon

data class Webtoon(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl : String,
    var rating: Float = 0.0f,
    var isFavorite: Boolean = false
)
fun getWebtoons(): List<Webtoon> {
    return listOf(
        Webtoon(
            id = 1,
            title = "Vagabond",
            description = "In 16th-century Japan, Shinmen Takezou is a wild, rough young man, in both his appearance and his actions. His aggressive nature has won him the collective reproach and fear of his village, leading him and his best friend, Matahachi Honiden, to run away in search of something grander than provincial life. The pair enlist in the Toyotomi army, yearning for glory—but when the Toyotomi suffer a crushing defeat at the hands of the Tokugawa Clan at the Battle of Sekigahara, the friends barely make it out alive.\n" +
                    "\n" +
                    "After the two are separated, Shinmen returns home on a self-appointed mission to notify the Hon'iden family of Matahachi's survival. He instead finds himself a wanted criminal, framed for his friend's supposed murder based on his history of violence. Upon being captured, he is strung up on a tree and left to die. An itinerant monk, the distinguished Takuan Soho, takes pity on the \"devil child,\" secretly freeing Shinmen and christening him with a new name to avoid pursuit by the authorities: Musashi Miyamoto.\n" +
                    "\n" +
                    "Vagabond is the fictitious retelling of the life of one of Japan's most renowned swordsmen, the \"Sword Saint\" Musashi Miyamoto—his rise from a swordsman with no desire other than to become \"Invincible Under the Heavens\" to an enlightened warrior who slowly learns of the importance of close friends, self-reflection, and life itself.\n",
            imageUrl = "https://shorturl.at/YKcPi",
            rating = 4.5f
        ),
        Webtoon(
            id = 2,
            title = "Berserk",
            description = "Guts, a former mercenary now known as the Black Swordsman, is out for revenge. After a tumultuous childhood, he finally finds someone he respects and believes he can trust, only to have everything fall apart when this person takes away everything important to Guts for the purpose of fulfilling his own desires. Now marked for death, Guts becomes condemned to a fate in which he is relentlessly pursued by demonic beings.\n" +
                    "\n" +
                    "Setting out on a dreadful quest " +
                    "riddled with misfortune, Guts, armed with " +
                    "a massive sword and monstrous strength, will let " +
                    "nothing stop him, not even death itself, until he" +
                    " is finally able to take the head of the one who stripped him—and his loved one—of their humanity.\n",
            imageUrl = "https://shorturl.at/gjsUs",
            rating = 4.8f
        ),
        Webtoon(
            id = 3,
            title = "A Talented Maid",
            description = "As Maurina, she's on the run as the" +
                    " last of her kingdom’s royal line. Disguised as Marie," +
                    " she is just a maid, serving the victorious empire." +
                    " She’s never been very good at anything, " +
                    "so when she's told to make a wish, she asks for" +
                    " the ability to help others and bring them happiness." +
                    " Now as visions of brilliant and skilled people fill her" +
                    " dreams, she’s imbued with a bounty of abilities " +
                    "perfectly suited for any dilemma. But will her secrets " +
                    "last as the crown prince seeks out both Maurina and Marie?\n",
            imageUrl = "https://cdn.anime-planet.com/manga/primary/a-talented-maid-1.jpg?t=1625843203\n",
            rating = 4.8f
        ),
        Webtoon(
            id = 4,
            title = "Doctor Elise: The Royal Lady with the Lamp",
            description = "Dr. Song, the youngest professor " +
                    "at the leading College of Medicine in Korea," +
                    " was a royal brat of a princess in her previous life." +
                    " But just as she’s about to meet an untimely death " +
                    "over the ocean, she wakes up as Princess Elise once" +
                    " again?! Enlightened with the medical knowledge of a " +
                    "master surgeon, is this her chance to mend her past" +
                    " relationships and heal an ailing empire," +
                    " or is fate sealed to repeat itself?\n",
            imageUrl = "https://cdn.anime-planet.com/manga/primary/doctor-elise-the-royal-lady-with-the-lamp-1.webp?t=1639783345",
            rating = 4.8f
        ),

        Webtoon(
            id = 5,
            title = "Who Made Me a Princess",
            description = "The beautiful Athanasia was killed at the hands " +
                    "of her own biological father, Claude de Alger Obelia," +
                    " the cold-blooded emperor! It’s just a silly bedtime story…" +
                    " until one woman wakes up to suddenly find she’s become that " +
                    "unfortunate princess! She needs a plan to survive her doomed" +
                    " fate, and time is running out. Will she go with Plan A, live as quietly as possible without being noticed by the infamous emperor? Plan B, collect enough money to escape the palace? Or will she be stuck with plan C," +
                    " sweet-talking her way into her father’s good graces?!\n",
            imageUrl = "https://cdn.anime-planet.com/manga/primary/who-made-me-a-princess-1.webp?t=1680663614\n",
            rating = 4.8f
        ),


        Webtoon(
            id = 6,
            title = "I Shall Master This Family",
            description = "The great Lombardi family was once at the " +
                    "top of the empire. After the death of its patriarch," +
                    " the fate of the family and that of Firentia, born from a" +
                    " Lombardi and a peasant, fall to ruin at the hands of her " +
                    "useless and cruel cousins. But when she’s reincarnated as her " +
                    "seven-year-old self, she’ll work to protect the family’s honor, gain her grandpa Lulac’s favor, and prevent her own father’s death. In this lifetime, there’s only one way for" +
                    " her to win: become the head of their mighty household.\n",
            imageUrl = "https://cdn.anime-planet.com/manga/primary/i-shall-master-this-family-1.jpg?t=1625874592",
            rating = 4.8f
        ),

        Webtoon(
            id = 7,
            title = "Solitary Lady",
            description = "Noblewoman Hillis Inoaden has had many lives so far" +
                    " (seven, to be exact) but she has always been regarded the same" +
                    " in all of them: meek, submissive, and a pest. But in her " +
                    "eighth resurrection, she no longer bends to the nobles that" +
                    " encircle her, nor does she continue to live in the shadows " +
                    "of her wicked brother and stepsister. With a sacred power passed down from her lineage and the title of Family Head, she sets out for revenge" +
                    " and to change the grave destiny that awaits her.\n",
            imageUrl = "https://rb.gy/goh8bm",
            rating = 4.8f
        ),

        Webtoon(
            id = 8,
            title = "Villains Are Destined to Die",
            description = "Playing Daughter of the Duke’s Super Love Project" +
                    " as the easy mode heroine, Ivonne, makes charming the" +
                    " male characters a breeze. But once you switch to hard mode" +
                    " and step into the shoes of Penelope, the misunderstood" +
                    " villain, it’s nearly impossible to even stay alive! So" +
                    " imagine the shock of suddenly waking up in Penelope’s body" +
                    "―you know right away that your life is on the line. With love interests who will kill you if their affection meters drop too low and the inability to speak without choosing from pre-selected dialogue, it quickly becomes clear that Penelope’s chances have been rigged from the start" +
                    "―and this villain might just be destined to die!\n",
            imageUrl = "https://shorturl.at/mbgL4",
            rating = 4.8f
        ),
        Webtoon(
          id = 9,
            title = "One Piece",
            description = "Gol D. Roger, a man referred to as the King of the Pirates, is set to be executed by the World Government. But just before his demise, he confirms the existence of a great treasure, One Piece, located somewhere within the vast ocean known as the Grand Line. Announcing that One Piece can be claimed by anyone worthy enough to reach it, the King of the Pirates is executed and the Great Age of Pirates begins.\n" +
                    "\n" +
                    "Twenty-two years later, a young man by the name of Monkey D. Luffy is ready to embark on his own adventure, searching for One Piece and striving to become the new King of the Pirates. Armed with just a straw hat, a small boat, and an elastic body, he sets out on a fantastic journey to gather his own crew and a worthy ship that will take them across the Grand Line to claim the greatest status on the high seas.\n",
            imageUrl = " https://shorturl.at/sNYxB",
            rating = 5.0f
        ),

        Webtoon(
            id = 10,
            title = "Grand Blue",
            description = "Among the seaside town of Izu's ocean waves and rays of shining sun, Iori Kitahara is just beginning his freshman year at Izu University. As he moves into his uncle's scuba diving shop, Grand Blue, he eagerly anticipates his dream college life, filled with beautiful girls and good friends.\n" +
                    "\n" +
                    "But things don't exactly go according to plan. Upon entering the shop, he encounters a group of rowdy, naked upperclassmen, who immediately coerce him into participating in their alcoholic activities. Though unwilling at first, Iori quickly gives in and becomes the heart and soul of the party. Unfortunately, this earns him the scorn of his cousin, Chisa Kotegawa, who walks in at precisely the wrong time. Undeterred, Iori still vows to realize his ideal college life, but will things go according to plan this time, or will his situation take yet another dive?\n" +
                    "\n",
            imageUrl = " https://shorturl.at/OHh4X"
        ),
        Webtoon(
            id = 11,
            title = "Solo Leveling",
            description = "E-class hunter Jinwoo Sung is the weakest of them all. Looked down on by everyone, he has no money, no abilities to speak of, and no other job prospects. So when his party finds a hidden dungeon, he's determined to use this chance to change his life for the better... but the opportunity he finds is a bit different from what he had in mind!\n",
            imageUrl = "https://shorturl.at/IzluH"

        ),

        Webtoon(
            id = 12,
            title = "Tomb Raider King",
            description = "Mysterious tombs appeared all over the world one day, each containing a relic which grants its owner supernatural abilities. Jooheon Suh is a tomb explorer, excavator, and raider. Betrayed by his employer, he's about to die at the hands of a powerful new relic when he suddenly finds himself 15 years in the past, before any relics or tombs made their debut. Driven by feelings of revenge, how will Jooheon use his knowledge of the future to become the Tomb Raider King?\n",
            imageUrl = "https://shorturl.at/1cc3w"
        )











    )
}
