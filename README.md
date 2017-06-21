# library
基础架构


# Git提交规范

1. Tag命名规规范

{major}.{feature}.{patch}+{year}w{weeks}{a-z:本周第一次发布}

2. 除develop和master之间的互合外，merge时，请务必加上 --no-ff 参数

3. 尽量以PR形式进行代码合并，对于重大改动，务必进行CodeReview

4. 如果提交了一堆杂乱无章的记录，需要使用 git rebase 重新整理这段提交

5. Commit Message 格式

<type>(<scope>):<subject>

type必须为以下几种之一：

> feat：特性提交

> fix：Bug修复提交

> docs：文档修改提交

> style：代码格式修改提交（空格、格式、缺失符号等）

> refactor：一个既不是特性也不是修复的其他代码提交

> perf：性能优化

> test：测试用例

> chore：构建工具、类库等修改的提交

score为影响范围，可选

subject为针对此次提交的文字描述
