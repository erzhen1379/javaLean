package leaning.structure.linkedlist.test01;

/**
 *实现单链表
 */
public class HeroNode {
    public int id;
    public String name;
    public String nickname;
    HeroNode nextNode;

    public HeroNode(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
