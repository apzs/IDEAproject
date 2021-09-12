package frame;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class BackGround {
    //当前场景的显示图片
    private BufferedImage bgImage = null;
    //场景的顺序
    private int sort;
    //当前是否为最后一个场景
    private boolean flag;
    //通过集合来保存
    //全部的敌人
    private List allEnemy = new ArrayList();

    public List<Obstruction> getAllObstruction() {
        return allObstruction;
    }

    public BufferedImage getBgImage() {
        return bgImage;
    }

    //全部的障碍物
    private List<Obstruction> allObstruction = new ArrayList<Obstruction>();
    //被消灭的敌人
    private List removeEnemy = new ArrayList();
    //被消灭的障碍物
    private List removedObstruction = new ArrayList();

    //构造方法
    public BackGround(int sort,boolean flag){  //sort：顺序  flag：标记，判断i是否为3，即是否为最后一个场景
        this.sort = sort;
        this.flag = flag;
        if(flag){
            bgImage = StaticValue.endImage;
        }else {
            bgImage = StaticValue.bgImage;
        }
        //判断是否为第一个场景
        if(sort == 1){
            //绘制地面
            for(int i = 0;i < 15;i++){   //  900/16=15块地面
                this.allObstruction.add(new Obstruction(i*60,540,9)); //600-60=540
            }
            //绘制砖块
            this.allObstruction.add(new Obstruction(120,360,4)); //第五个图片的下标为4
            this.allObstruction.add(new Obstruction(300,360,0));
            this.allObstruction.add(new Obstruction(360,360,4));
            this.allObstruction.add(new Obstruction(420,360,0));
            this.allObstruction.add(new Obstruction(480,360,4));
            this.allObstruction.add(new Obstruction(540,360,0));
            this.allObstruction.add(new Obstruction(420,180,4));
            //绘制水管
            this.allObstruction.add(new Obstruction(660,540,6));
            this.allObstruction.add(new Obstruction(720,540,5));
            this.allObstruction.add(new Obstruction(660,480,8));
            this.allObstruction.add(new Obstruction(720,480,7));

        }
    }

    //重置方法，将所有的障碍物和敌人返回到原有坐标，并将其状态也修改



}
