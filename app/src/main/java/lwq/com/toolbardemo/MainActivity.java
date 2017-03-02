package lwq.com.toolbardemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        // APP 的图标
        toolbar.setLogo(R.mipmap.ic_launcher);
        // 主标题
        toolbar.setTitle("My Title");
        // 主标题的颜色
        toolbar.setTitleTextColor(Color.BLUE);
        // 副标题
        toolbar.setSubtitle("Sub title");
        //取代原本的actionbar
        setSupportActionBar(toolbar);

        // 侧边栏的按钮的图标
        // Navigation Icon 要设定在 setSupoortActionBar 才有作用
        toolbar.setNavigationIcon(R.drawable.ab_android);
        //设置NavigationIcon的点击事件,需要放在setSupportActionBar之后设置才会生效,
        //因为setSupportActionBar里面也会setNavigationOnClickListener
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ab_android", Toast.LENGTH_SHORT).show();
            }
        });

        //ToolBar里面还可以包含子控件
        toolbar.findViewById(R.id.tv_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "自定义标题", Toast.LENGTH_SHORT).show();
            }
        });

        //Menu item click的监听事件要设在setSupportActionBar才有作用
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_edit:
                    msg += "Click edit";
                    break;
                case R.id.action_share:
                    msg += "Click share";
                    break;
                case R.id.action_settings:
                    msg += "Click setting";
                    break;
            }
            if (!msg.equals("")) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //为了让Toolbar的Menu起作用
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
