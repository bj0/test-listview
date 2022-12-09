package gov.jeaco.testlv

class PageB(val pagea: PageA) {

    fun click() {
        pagea.items.value += "new item"
    }

}