DROP TABLE IF EXISTS standard;
CREATE TABLE standard (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  std_num      VARCHAR(50) NOT NULL UNIQUE,
  zhname       VARCHAR(50) NOT NULL,
  version      VARCHAR(50) NOT NULL,
  skeys        VARCHAR(50) NOT NULL,
  release_date DATE        NOT NULL,
  impl_date    DATE        NOT NULL,
  package_path VARCHAR(100)
);
INSERT INTO standard (std_num, zhname, version, skeys, release_date, impl_date, package_path)
VALUES ('GB 6657.1-2014', '玩具安全 第一部分：基本规范', '2014', '玩具、基本规范', '2014-05-06', '2016-01-01',
        'E:\IDEAproject\StuStstem\out\artifacts\StuStstem_war_exploded\uploadFile\Python-logo-notext.svg.png');
INSERT INTO standard (std_num, zhname, version, skeys, release_date, impl_date, package_path)
VALUES ('GB 6657.2-2014', '玩具安全 第二部分：机械与物理性能', '2014', '玩具、机械与物理性能', '2014-05-06', '2016-01-01',
        'E:\IDEAproject\StuStstem\out\artifacts\StuStstem_war_exploded\uploadFile\Python-logo-notext.svg.png');
INSERT INTO standard (std_num, zhname, version, skeys, release_date, impl_date, package_path)
VALUES ('GB 6657.3-2014', '玩具安全 第三部分：易燃性能', '2014', '玩具、易燃性能', '2014-05-06', '2016-01-01',
        'E:\IDEAproject\StuStstem\out\artifacts\StuStstem_war_exploded\uploadFile\Python-logo-notext.svg.png');
INSERT INTO standard (std_num, zhname, version, skeys, release_date, impl_date, package_path)
VALUES ('GB 6657.4-2014', '玩具安全 第四部分：特定元素的迁移', '2014', '玩具、特定元素迁移', '2014-05-06', '2016-01-01',
        'E:\IDEAproject\StuStstem\out\artifacts\StuStstem_war_exploded\uploadFile\Python-logo-notext.svg.png');
INSERT INTO standard (std_num, zhname, version, skeys, release_date, impl_date, package_path)
VALUES ('GB 6657.5-2014', '玩具安全 第一部分：基本规范', '2014', '玩具、基本规范', '2014-05-06', '2016-01-01',
        'E:\IDEAproject\StuStstem\out\artifacts\StuStstem_war_exploded\uploadFile\Python-logo-notext.svg.png');
INSERT INTO standard (std_num, zhname, version, skeys, release_date, impl_date, package_path)
VALUES ('GB 6657.6-2014', '玩具安全 第一部分：基本规范', '2014', '玩具、基本规范', '2014-05-06', '2016-01-01',
        'E:\IDEAproject\StuStstem\out\artifacts\StuStstem_war_exploded\uploadFile\Python-logo-notext.svg.png');